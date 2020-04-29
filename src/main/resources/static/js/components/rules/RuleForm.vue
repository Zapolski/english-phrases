<template>
  <div>
    <input type="text" placeholder="Write rule" v-model="value" />
    <input type="button" value="Add" @click="saveRule" />
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  props: ["ruleAttr"],
  data() {
    return {
      value: "",
      id: ""
    };
  },
  watch: {
    ruleAttr(newVal, oldVal) {
      this.value = newVal.value;
      this.id = newVal.id;
    }
  },
  methods: {
    ...mapActions(["addRuleAction", "updateRuleAction"]),
    saveRule() {
      const rule = {
        id: this.id,
        value: this.value
      };

      if (this.id) {
        this.updateRuleAction(rule);
      } else {
        this.addRuleAction(rule);
      }

      this.id = "";
      this.value = "";
    }
  }
};
</script>

<style scoped>
</style>