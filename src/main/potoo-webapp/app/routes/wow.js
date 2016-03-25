import Ember from 'ember';

export default Ember.Route.extend({

  init() {
    this._super(...arguments);
  },


  model: function(params) {
    return this.store.findRecord('wow', params.id);
  }
});
