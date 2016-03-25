import DS from 'ember-data';

export default DS.Transform.extend({
  deserialize: function(serialized) {
    let date = moment(serialized);
    return date.format('MMMM Do YYYY, h:mm:ss a');
  },

  serialize: function(deserialized) {
    return deserialized;
  }
});
