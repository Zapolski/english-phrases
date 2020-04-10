function getIndex(list, id) {
  for (var i = 0; i < list.length; i++ ) {
      if (list[i].id === id) {
          return i;
      }
  }
  return -1;
}

var ruleApi = Vue.resource('/rules{/id}');

Vue.component('rule-form', {
  props: ['rules','ruleAttr'],
  data: function () {
    return {
      value: '',
      id: ''
    }
  },
  watch:{
    ruleAttr: function(newVal, oldVal){
      this.value = newVal.value;
      this.id = newVal.id;
    }
  },
  template:
    '<div>' +
        '<input type="text" placeholder="Write rule" v-model="value" />' +
        '<input type="button" value="Add" @click="addRule" />' +
    '</div>',
  methods: {
    addRule: function () {
      var rule = {value: this.value};

      if (this.id){
        ruleApi.update({id: this.id}, rule).then(result =>{
          result.json().then(data =>{
            var index = getIndex(this.rules, data.id);
            this.rules.splice(index, 1, data);
            this.value='';
            this.id='';
          })
        })
      }else{
        ruleApi.save({},rule).then(result =>{
          result.json().then(data => {
            this.rules.push(data);
            this.value='';
          })
        })
      }
    }
  }
})

Vue.component('rule-row', {
  props: ['rule','editRuleMethod','rules'],
  template: 
    '<div>'+
      '<i>({{ rule.id }})</i> {{rule.value}}' +
      '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="editRule" />' +
        '<input type="button" value="X" @click="delRule" />' +
      '</span>' +
    '</div>',
    methods:{
      editRule: function(){
          this.editRuleMethod(this.rule);
      },
      delRule: function(){
        ruleApi.remove({id: this.rule.id}).then(result =>{
          if (result.ok){
            this.rules.splice(this.rules.indexOf(this.rule),1)
          }
        })
      }
    }
});

Vue.component('rules-list', {
  props: ['rules'],
  data: function(){
    return {
      rule: null
    }
  },
  template:
    '<div style="position: relative; width: 300px;">' +
      '<rule-form :rules="rules" :ruleAttr="rule"/> ' +
      '<rule-row v-for="rule in rules" :key="rule.id" :rule="rule" :editRuleMethod="editRuleMethod" :rules="rules"/>' +
    '</div>',
  created: function () {
    ruleApi.get().then(result =>
      result.json().then(data =>
        data.forEach(rule => this.rules.push(rule))
      )
    )
  },
  methods: {
    editRuleMethod: function(rule){
      this.rule = rule;
    }
  }
});


var app = new Vue({
  el: '#app',
  template: '<rules-list :rules="rules"/>',
  data: {
    rules: []
  }
});