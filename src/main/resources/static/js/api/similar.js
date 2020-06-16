import Vue from 'vue';

const api = Vue.resource('/words/frequency')

export default {
    getSimilarWords: (word, threshold) => api.get({ word: word, threshold: threshold }),
    add: wordWithFrequency => api.save({}, wordWithFrequency),
}