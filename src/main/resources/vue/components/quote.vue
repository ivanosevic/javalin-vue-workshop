<template id="quote">
  <figure class="text-center">
    <blockquote class="blockquote">
      <p>{{ content }}</p>
    </blockquote>
    <figcaption class="blockquote-footer">
      <cite title="Source Title">{{ source }}</cite>
    </figcaption>
  </figure>
</template>
<script>
app.component("quote", {
  template: "#quote",
  props: {
    content: String,
    source: String
  }
});
</script>
<style>

</style>