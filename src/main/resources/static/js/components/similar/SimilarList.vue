<template>
  <div>
    <similar-row v-for="info in similarWords" :key="info.id" :info="info" />
  </div>
</template>

<script>
import SimilarRow from "components/similar/SimilarRow.vue";

export default {
  components: {
    SimilarRow
  },

  props: ["similarWords"]
};
</script>

<style scoped>
</style>