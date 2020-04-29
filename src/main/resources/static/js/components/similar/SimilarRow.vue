<template>
  <div>
    <i>({{ info.id }})</i>
    {{info.value}} {{info.rank}} {{info.partOfSpeech}} {{info.similarity.toFixed(2)}}
  </div>
</template>

<script>
export default {
  props: ["info"]
};
</script>

<style scoped>
</style>