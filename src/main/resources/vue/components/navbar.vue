<template id="navbar">
  <nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">{{ title }}</a>
      <a class="btn btn-outline-success me-2" href="/add-quote">Add Quote</a>
    </div>
  </nav>
</template>
<script>
app.component("navbar", {
  template: "#navbar",
  props: {
    title: String,
  }
});
</script>
<style>

</style>