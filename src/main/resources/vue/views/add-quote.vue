<template id="add-quote">
  <section>
    <header>
      <navbar title="Quotes"/>
    </header>
    <main class="container">
      <form action="/add-quotes" method="post" accept-charset="UTF-8">
        <div class="mb-3">
          <label for="content" class="form-label">Quote</label>
          <textarea class="form-control" id="content" name="content" rows="3" minlength="1" maxlength="500"
                    required></textarea>
        </div>

        <div class="mb-3">
          <label for="source" class="form-label">Source</label>
          <input class="form-control" list="datalistOptions" id="source" name="source" placeholder="Enter Source"
                 required>
          <datalist id="datalistOptions">
            <option value="San Francisco"></option>
            <option value="New York"></option>
            <option value="Seattle"></option>
            <option value="Los Angeles"></option>
            <option value="Chicago"></option>
          </datalist>
        </div>

        <button type="submit" class="btn btn-primary">Add</button>
      </form>
    </main>
  </section>
</template>
<script>
app.component("add-quote", {
  template: "#add-quote"
});
</script>
<style>
html, body {
  margin: 0 auto;
  height: 100%;
}
</style>