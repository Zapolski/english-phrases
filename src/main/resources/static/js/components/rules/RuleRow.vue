<template>
  <div>
    <i>({{ rule.id }})</i>
    {{rule.value}}
    <span style="position: absolute; right: 0">
      <input type="button" value="Edit" @click="editRule" />
      <input type="button" value="X" @click="delRule" />
    </span>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: ["rule", "editRuleMethod"],
  methods: {
    ...mapActions(['removeRuleAction']),
    editRule() {
      this.editRuleMethod(this.rule);
    },
    delRule() {
      this.removeRuleAction(this.rule);
    }
  }
};
</script>

<style scoped>
</style>