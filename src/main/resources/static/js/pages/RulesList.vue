<template>
  <div style="position: relative; width: 300px;">
    <h2>Rules list</h2>
    <rule-form :ruleAttr="rule" />
    <rule-row
      v-for="rule in sortedRules"
      :key="rule.id"
      :rule="rule"
      :editRuleMethod="editRuleMethod"
    />
  </div>
</template>

<script>
import RuleRow from "components/rules/RuleRow.vue";
import RuleForm from "components/rules/RuleForm.vue";
import { mapGetters } from "vuex";
import { mapActions } from "vuex";

export default {
  components: {
    RuleRow,
    RuleForm
  },
  data() {
    return {
      rule: null
    };
  },
  computed: mapGetters(["sortedRules"]),
  created: function() {
    this.getAllRuleAction();
  },
  methods: {
    ...mapActions(["addRuleAction", "getAllRuleAction"]),
    editRuleMethod(rule) {
      this.rule = rule;
    }
  }
};
</script>

<style scoped>
</style>