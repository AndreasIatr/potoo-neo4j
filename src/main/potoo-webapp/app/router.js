import Ember from 'ember';
import config from './config/environment';

var Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('wows');
  this.route('wow', { path: '/wow/:id' });
});

export default Router;
