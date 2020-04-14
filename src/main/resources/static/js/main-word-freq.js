var wordsWithFreuqApi = Vue.resource('/words/frequency');


Vue.component('similarity-page', {
  props: ["similarWords"],
  template:
    '<div>' +
    '<request-form :similarWords="similarWords"/>' +
    '<similarities-list :similarWords="similarWords"/>' +
    '</div>'
});


Vue.component('request-form', {
  props: ["similarWords"],
  data: function () {
    return {
      word: '',
      threshold: ''
    }
  },
  template:
    '<div>' +
    '<label>Word</label>' +
    '<input type="text" placeholder="Write word" v-model="word" />' +
    '<br>' +
    '<label>Threshold</label>' +
    '<input type="text" placeholder="Write threshold" v-model="threshold" />' +
    '<br>' +
    '<input type="button" value="Find" @click="findSimilarities" />' +
    '<br>' +
    '</div>',
  methods: {
    findSimilarities: function () {
      this.similarWords.splice(0);
      wordsWithFreuqApi.get({ word: this.word, threshold: this.threshold }).then(result =>
        result.json().then(data => {
          console.log(data);
          data.forEach(info => this.similarWords.push(info));
        }
        )
      )
    }
  }
});

Vue.component('similarities-list', {
  props: ["similarWords"],
  template:
    '<div>' +
    '<similarities-row v-for="info in similarWords" :key="info.id" :info="info"/>' +
    '</div>'
});

Vue.component('similarities-row', {
  props: ["info"],
  template:
    '<div>' +
    '<i>({{ info.id }})</i> {{info.value}} {{info.rank}} {{info.partOfSpeech}} {{info.similarity.toFixed(2)}}' +
    '</div>'
});

//Vue.component('rule-row', {
//  props: ['rule','editRuleMethod','rules'],
//  template:
//    '<div>'+
//      '<i>({{ rule.id }})</i> {{rule.value}}' +
//      '<span style="position: absolute; right: 0">' +
//        '<input type="button" value="Edit" @click="editRule" />' +
//        '<input type="button" value="X" @click="delRule" />' +
//      '</span>' +
//    '</div>',
//    methods:{
//      editRule: function(){
//          this.editRuleMethod(this.rule);
//      },
//      delRule: function(){
//        ruleApi.remove({id: this.rule.id}).then(result =>{
//          if (result.ok){
//            this.rules.splice(this.rules.indexOf(this.rule),1)
//          }
//        })
//      }
//    }
//});
//
//Vue.component('rules-list', {
//  props: ['rules'],
//  data: function(){
//    return {
//      rule: null
//    }
//  },
//  template:
//    '<div style="position: relative; width: 300px;">' +
//      '<rule-form :rules="rules" :ruleAttr="rule"/> ' +
//      '<rule-row v-for="rule in rules" :key="rule.id" :rule="rule" :editRuleMethod="editRuleMethod" :rules="rules"/>' +
//    '</div>',
//  created: function () {
//    ruleApi.get().then(result =>
//      result.json().then(data =>
//        data.forEach(rule => this.rules.push(rule))
//      )
//    )
//  },
//  methods: {
//    editRuleMethod: function(rule){
//      this.rule = rule;
//    }
//  }
//});


var app = new Vue({
  el: '#app',
  template:
    '<similarity-page :similarWords="similarWords"/>',
  data: {
    similarWords: []
  }
});