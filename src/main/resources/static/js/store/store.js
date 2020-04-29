import Vue from 'vue'
import Vuex from 'vuex'
import rulesApi from 'api/rules'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        rules: [],
    },
    getters: {
        sortedRules: state => state.rules.sort((a, b) => -(a.id - b.id))
    },
    mutations: {
        addRuleMutation(state, rule) {
            state.rules = [
                ...state.rules,
                rule
            ]
        },
        updateRuleMutation(state, rule) {
            const updateIndex = state.rules.findIndex(item => item.id === rule.id)
            state.rules = [
                ...state.rules.slice(0, updateIndex),
                rule,
                ...state.rules.slice(updateIndex + 1)
            ]
        },
        removeRuleMutation(state, rule) {
            const deletionIndex = state.rules.findIndex(item => item.id === rule.id)
            if (deletionIndex > -1) {
                state.rules = [
                    ...state.rules.slice(0, deletionIndex),
                    ...state.rules.slice(deletionIndex + 1)
                ]
            }
        },
        setRulesMutation(state, rules){
            state.rules = rules;
        }
    },
    actions: {
        async addRuleAction({ commit }, rule) {
            const result = await rulesApi.add(rule)
            const data = await result.json()
            const index = this.state.rules.findIndex(item => item.id === rule.id)

            if (index > -1) {
                commit('updateRuleMutation', data)
            } else {
                commit('addRuleMutation', data)
            }
        },
        async updateRuleAction({ commit }, rule) {
            const result = await rulesApi.update(rule)
            const data = await result.json()
            commit('updateRuleMutation', data)
        },
        async removeRuleAction({ commit }, rule) {
            const result = await rulesApi.remove(rule.id)

            if (result.ok) {
                commit('removeRuleMutation', rule)
            }
        },
        async getAllRuleAction({ commit }){
            const result = await rulesApi.getAll()
            const data = await result.json()
            commit('setRulesMutation',data)
        }
    }
})