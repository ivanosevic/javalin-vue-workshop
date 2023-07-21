<template id="quotes-list">
  <div v-if="quotes.loading">
    <h2 class="text-center">Loading quotes ...</h2>
  </div>
  <div v-if="quotes.loadError">
    <h2 class="text-center">Failed to load quotes ({{ quotes.loadError.text }})</h2>
  </div>
  <div v-if="quotes.loaded">
    <ul class="list-group">
      <li class="list-group-item" v-for="quote in quotes.data">
        <quote :content="quote.content" :source="quote.source"/>
      </li>
    </ul>
  </div>
</template>
<script>
app.component("quotes-list", {
  template: "#quotes-list",
  props: {
    quotes: Object
  }
});
</script>
<style>

</style>