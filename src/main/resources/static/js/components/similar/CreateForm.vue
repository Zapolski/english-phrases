<template>
  <div>
    <br />
    <br />
    <!-- <label>Id:</label>
    <input type="text" placeholder="Write id" v-model="id" />
    <br /> -->

    <label>Word:</label>
    <input type="text" placeholder="Write value" v-model="value" />
    <br />

    <label>Rank:</label>
    <input type="text" placeholder="Write rank" v-model="rank" />
    <br />

    <label>Part of speech:</label>
    <input type="text" placeholder="Write part of speech" v-model="partOfSpeech" />
    <br />
    <input type="button" value="Add" @click="saveWord" />
  </div>
</template>

<script>
import similarApi from "api/similar";

export default {
  props: ["wordWithFrequencyAttr"],
  data() {
    return {
      id: "",
      value: "",
      rank: "",
      partOfSpeech: ""
    };
  },
  watch: {
    ruleAttr(newVal, oldVal) {
      this.id = newVal.id;
      this.value = newVal.value;
      this.rank = newVal.rank;
      this.partOfSpeech = newVal.partOfSpeech;
    }
  },
  methods: {
    async saveWord() {
      const wordWithFrequency = {
        id: this.id,
        value: this.value,
        rank: this.rank,
        partOfSpeech: this.partOfSpeech
      };

      const result = await similarApi.add(wordWithFrequency);
      if (result.ok) {
        alert("Word was successful added!");
        this.id = "";
        this.value = "";
        this.rank = "";
        this.partOfSpeech = "";
      } else {
        alert("Error during adding!");
      }
    }
  }
};
</script>

<style scoped>
</style>