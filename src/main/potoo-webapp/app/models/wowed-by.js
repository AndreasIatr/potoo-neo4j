import DS from 'ember-data';

export default DS.Model.extend({
  user: DS.belongsTo('user'),
  wow: DS.belongsTo('wow', { inverse: null }),
  when: DS.attr('neo-date')
});
