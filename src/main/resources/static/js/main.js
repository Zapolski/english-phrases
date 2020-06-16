// import 'material-design-icons-iconfont/src/material-design-icons.scss'

import Vue from 'vue'
import '@babel/polyfill'
import 'api/resource'
import App from 'pages/App.vue'
import store from 'store/store'
import router from 'router/router'

new Vue({
  el: '#app',
  store, 
  router,
  render : a => a(App)
})
