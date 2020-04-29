<template>
  <div>
    <h2>Similar words</h2>
    <div>
      <request-form :similarWords="similarWords" />
      <similar-list :similarWords="similarWords" />
    </div>
  </div>
</template>

<script>
import RequestForm from "components/similar/RequestForm.vue"
import SimilarList from "components/similar/SimilarList.vue"

export default {
  components: {
    RequestForm, SimilarList
  },

  data() {
    return {
      similarWords: []
    };
  },
};
</script>

<style scoped>
</style>