<template>
  <div>
    <label>Word</label>
    <input type="text" placeholder="Write word" v-model="word" />
    <br />
    <label>Threshold</label>
    <input type="text" placeholder="Write threshold" v-model="threshold" />
    <br />
    <input type="button" value="Find" @click="findSimilarities" />
    <br />
  </div>
</template>

<script>
import similarApi from 'api/similar'

export default {
  props: ["similarWords"],

  data() {
    return {
      word: "",
      threshold: ""
    };
  },

  methods:{
    async findSimilarities() {
      this.similarWords.splice(0)
      const result = await similarApi.getSimilarWords(this.word, this.threshold)
      const data = await result.json()        
      data.forEach(info => this.similarWords.push(info));
    }
  }
};
</script>


<style scoped>
</style>