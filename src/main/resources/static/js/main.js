import Vue from 'vue'
import App from 'pages/App.vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)


new Vue({
  el: '#app',
  render : a => a(App)
})

/*
function getIndex(list, id) {
  for (var i = 0; i < list.length; i++ ) {
      if (list[i].id === id) {
          return i;
      }
  }
  return -1;
}

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
*/
