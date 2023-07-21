<template id="index">
  <section>
    <header>
      <navbar title="Quotes"/>
    </header>
    <main>
      <quotes-list :quotes="quotes"/>
    </main>
  </section>
</template>
<script>
app.component("index", {
  template: "#index",
  data: () => ({
    quotes: new LoadableData("/api/v1/quotes"),
  }),
  created() {
    this.quotes.refresh();
  }
});
</script>
<style>
html, body {
  margin: 0 auto;
  height: 100%;
}
</style>