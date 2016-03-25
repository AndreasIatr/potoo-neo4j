import DS from 'ember-data';

export default DS.RESTSerializer.extend({
  //normalizeFindRecordResponse(store, type, payload) {
  //  console.log(payload);
  //  return {
  //    data: {
  //      id: payload.wow.id,
  //      type: type.modelName,
  //      attributes: {
  //        wow: payload.wow.wow,
  //        reWows: payload.wow.reWows,
  //        wowedBy: payload.wow.wowedBy
  //      }
  //    }
  //  };
  //}
});


  //extractSingle: function extractSingle(store, primaryType, payload, recordId) {
  //    var newPayload, typeKey;
  //    typeKey = primaryType.typeKey;
  //    newPayload = {};
  //    if (payload[typeKey] && typeof payload[typeKey] === 'object') {
  //      newPayload = payload;
  //    } else {
  //      newPayload[typeKey] = payload;
  //    }
  //    return this._super(store, primaryType, newPayload, recordId);
  //  },
  //  extractArray: function extractArray(store, primaryType, payload) {
  //    var newPayload, pluralTypeKey;
  //    pluralTypeKey = Ember.Inflector.inflector.pluralize(primaryType.typeKey);
  //    newPayload = {};
  //    if (payload[pluralTypeKey] && typeof payload[pluralTypeKey] === 'object') {
  //      newPayload = payload;
  //    } else {
  //      newPayload[pluralTypeKey] = Array.isArray(payload) ? payload : [payload];
  //    }
  //    return this._super(store, primaryType, newPayload);
  //  }

