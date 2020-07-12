<template>
  <div class="v-btn" :class="className" @click="click">
      <i class="material-icons" v-if="icon">{{icon}}</i>
      <i class="material-icons">contact_support</i>
    <span>{{title}}</span>
  </div>
</template>

<script>

export default {

  name: "v-btn",

  props: {
    title: {
      type: String,
      default: "Button"
    },
    disabled: {
      type: Boolean,
      default: false
    },
    icon:{
        type: String,
        default: ''
    }
  },
  data() {
    return {};
  },
  methods: {
    click() {
      this.$emit("click");
    }
  },
  computed: {
    className() {
      return {
        "v-btn__disabled": this.disabled
      };
    }
  }
};
</script>

<style lang="scss">
.v-btn {
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 4px;
  padding: 8px 16px;
  color: #ffffff;
  background: red;
  margin-top: 60px;
  max-width: 200px;

  cursor: pointer;

  /* запрет выделения текста */
  -webkit-user-select: none; /* Google Chrome, Opera Next, Safari */
}

.v-btn:hover {
  background: #ff887c;
}

.v-btn__disabled {
  /* выключение событий (имитация disabled)  */
  pointer-events: none;
}

.material-icons {
  margin-right: 8px;
  font-size: 16px;
}
</style>