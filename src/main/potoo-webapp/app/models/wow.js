import DS from 'ember-data';

export default DS.Model.extend({
  wow: DS.attr(),
  reWows: DS.belongsTo('re-wows', { inverse: null }),
  wowedBy: DS.belongsTo('wowed-by', { inverse: null })
});
