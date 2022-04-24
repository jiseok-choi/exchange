<!--<template>-->

<!--  <v-container>-->
<!--    <h1>환율 계산</h1>-->
<!--    <br/>-->
<!--    <row>-->

<!--    </row>-->
<!--    <h2>송금국가: 미국(USD)</h2>-->
<!--    <h2>수취국가:</h2>-->
<!--  </v-container>-->
<!--</template>-->

<template>
  <table style="table-layout: fixed; width: 100%">
    <colgroup>
      <col style="width: 100%">
    </colgroup>
    <thead>
    <tr>
      <th>
        <h1>환율 계산</h1>
        <br/>
      </th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td><h2>송금국가: 미국(USD)</h2></td>
    </tr>
    <tr>
      <td>
        <h2>
          수취국가:
          <select v-model="this.selected">
            <option value="krw">한국(KRW)</option>
            <option value="jpy">일본(JPY)</option>
            <option value="php">필리핀(PHP)</option>
          </select>

        </h2>

      </td>
    </tr>
    <tr>
      <td>
        <h2>환율:</h2>
      </td>
    </tr>
    <tr>
      <td>
        <h2>송금액: </h2>
      </td>
    </tr>
    <tr>
      <td>
        <button v-on:click="getRateInfo">Submit</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import Axios from 'axios';

export default {
  name: "MainFront",

  data() {
    return {
      selected: 'krw'
    }
  },

  mounted() {
    this.init()
  },

  methods: {

    init() {
      console.log("mounted!!", this.selected);
    },

    getRateInfo() {
      Axios.get('/localhost:8090/exchange')
        .then(res => {
          console.log(res);
        })
    }
  }

}
</script>

<style scoped>

</style>
