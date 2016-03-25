import DS from 'ember-data';

export default DS.Model.extend({
  wow: DS.belongsTo('wow'),
  originalWow: DS.belongsTo('wow')
});
