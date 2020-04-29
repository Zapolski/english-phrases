import Vue from 'vue'
import VueRouter from 'vue-router'
import RulesList from 'pages/RulesList.vue'
import About from 'pages/About.vue'
import SimilarWords from 'pages/SimilarWords.vue'

// чтобы не выскакивало ошибки дубликата при повторном нажатии на одну и ту же ссылку
const routerPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error => error)
}

Vue.use(VueRouter)

const routes = [
  { path: '/', component: About },
  { path: '/rules/list', component: RulesList },
  { path: '/similar', component: SimilarWords },
  { path: '/about', component: About },
  { path: '*', component: About }
]

export default new VueRouter({
  mode: 'history',
  routes // сокращённая запись для `routes: routes`
})