<template>
  <div>
    <h2>Similar words</h2>
    <div>
      <request-form :similarWords="similarWords" />
      <similar-list :similarWords="similarWords" />
      <create-form :wordWithFrequencyAttr="wordWithFrequency" />
      <v-btn @click="clickBtn" :disabled="false" title="Add" icon="edit"/>
    </div>
  </div>
</template>

<script>
import RequestForm from "components/similar/RequestForm.vue";
import SimilarList from "components/similar/SimilarList.vue";
import CreateForm from "components/similar/CreateForm.vue";

import vBtn from "components/v-btn.vue";

export default {
  components: {
    RequestForm,
    SimilarList,
    CreateForm,
    vBtn
  },

  data() {
    return {
      similarWords: [],
      wordWithFrequency: null
    };
  },

  methods:{
    clickBtn(){
      alert('Click!')
    }
  }
};
</script>

<style scoped>
</style>