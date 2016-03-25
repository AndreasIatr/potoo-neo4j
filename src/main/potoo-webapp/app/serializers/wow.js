import DS from 'ember-data';

export default DS.RESTSerializer.extend(DS.EmbeddedRecordsMixin, {
  attrs: {
    reWows: {embedded: 'always'},
    wowedBy: {embedded: 'always'}
  }
});
