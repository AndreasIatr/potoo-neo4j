package potoo.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.validation.constraints.NotNull;

import org.atteo.evo.inflector.English;
import org.springframework.util.Assert;

import com.google.common.base.CaseFormat;

@SuppressWarnings("serial")
public final class EmberModel extends ConcurrentHashMap<String, Object> {

    private EmberModel() {
        super();
        //Must use the builder
    }

    // Factory method
    private static EmberModel createEmberModel() {
        return new EmberModel();
    }

    public static class Builder {
        private final ConcurrentMap<String, Object> sideLoadedItems = new ConcurrentHashMap<String, Object>();
        private final ConcurrentMap<String, Object> metaData = new ConcurrentHashMap<String, Object>();

        public Builder(final Object entity) {
            Assert.notNull(entity);
            sideLoad(entity);
        }

        public Builder(final String rootName, final Object entity) {
            Assert.notNull(entity);
            sideLoad(rootName, entity);
        }

        public Builder(final Class<?> clazz, final Collection<?> entities) {
            Assert.notNull(entities);
            sideLoad(clazz, entities);
        }

        public Builder(final String rootName, final Collection<?> entities) {
            Assert.notNull(entities);
            sideLoad(rootName, entities);
        }

        public Builder(final String rootName, final Collection<?> entities, final boolean isRootNameAlreadyPlural) {
            Assert.notNull(entities);
            sideLoad(rootName, entities, isRootNameAlreadyPlural);
        }

        public Builder addMeta(@NotNull final String key, final Object value) {
            if (value != null) {
                metaData.put(key, value);
            }
            return this;
        }

        public Builder sideLoad(final Object entity) {
            if (entity != null) {
                sideLoadedItems.put(getSingularName(entity.getClass()), entity);
            }
            return this;
        }
        
        public Builder sideLoad(final Object entity, final String field) {
        	try {
				Method getter = entity.getClass().getMethod("get" + field);
				Object gotEntity = getter.invoke(entity);
				Set<Object> entities = new HashSet<>();
				entities.add(entity);
				if (gotEntity != null) {
					sideLoadedItems.put(toLowerCamel(field), entities);
				}
			} catch (NoSuchMethodException | SecurityException |
					IllegalAccessException | IllegalArgumentException |
					InvocationTargetException e) {
				e.printStackTrace();
			}
        	
        	return this;
        }

        //Internal use only
        private Builder sideLoad(final String rootName, final Object entity) {
            if (entity != null) {
                sideLoadedItems.put(rootName, entity);
            }
            return this;
        }

        public Builder sideLoad(final Class<?> clazz, final Collection<?> entities) {
            if (entities != null) {
                sideLoadedItems.put(getPluralName(clazz), entities);
            }
            return this;
        }

        public Builder sideLoad(final String rootName, final Collection<?> entities) {
            if (entities != null) {
                sideLoadedItems.put(English.plural(rootName), entities);
            }
            return this;
        }

        public Builder sideLoad(final String rootName, final Collection<?> entities, final boolean isRootAlreadyPlural) {
            if (entities != null) {
                if (isRootAlreadyPlural) {
                    sideLoadedItems.put(rootName, entities);
                } else {
                    sideLoadedItems.put(English.plural(rootName), entities);
                }
            }
            return this;
        }

        private String getSingularName(final Class<?> clazz) {
            Assert.notNull(clazz);
            return toLowerCamel(clazz.getSimpleName());
        }
        
        private String toLowerCamel(String text) {
        	return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, text);
        }

        private String getPluralName(final Class<?> clazz) {
            return English.plural(getSingularName(clazz));
        }


        public EmberModel build() {
            if (metaData.size() > 0) {
                sideLoadedItems.put("meta", metaData);
            }
            final EmberModel sideLoader = createEmberModel();
            sideLoader.putAll(sideLoadedItems);
            return sideLoader;
        }
    }
}
