import Vue from 'vue';

const api = Vue.resource('/rules{/id}')

export default {
    add: rule => api.save({}, rule),
    update: rule => api.update({id: rule.id}, rule),
    remove: id => api.remove({id}),
    getAll: () => api.get()
}