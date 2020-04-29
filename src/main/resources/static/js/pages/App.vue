<template>
  <div>
    <div>
      <input type="button" value="Rules" @click="showRules">
      <input type="button" value="Similar words" @click="showSimilar">
      <input type="button" value="About" @click="showAbout">
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  methods:{
    showRules(){
      this.$router.push('/rules/list')
    },
    showSimilar(){
      this.$router.push('/similar')
    },
    showAbout(){
      this.$router.push('/about')
    }    
  }
};
</script>

<style scoped>
</style>