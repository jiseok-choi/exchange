
<template>
  <table style="table-layout: fixed; text-align: center; width: 100%">
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
          <select v-model="this.country" @change="countryChange()">
            <option value="krw">한국(KRW)</option>
            <option value="jpy">일본(JPY)</option>
            <option value="php">필리핀(PHP)</option>
          </select>

        </h2>

      </td>
    </tr>
    <tr>
      <td>
        <h2>환율: {{ this.rateText }} {{ this.country.toUpperCase() }}/USD</h2>
      </td>
    </tr>
    <tr>
      <td>
        <h2>송금액: <input v-model="this.remittanceAmount"/> USD</h2>
      </td>
    </tr>
    <tr>
      <td>
        <button v-on:click="calculator">Submit</button>
      </td>
    </tr>
    <tr>
      <td>
        <h1>{{ this.message }}</h1>
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
      country: 'krw',
      rate: 1,
      rateText: '',
      remittanceAmount: 0,
      message: ''
    }
  },

  mounted() {
    this.init()
  },

  methods: {

    init() {
      this.getRateInfo();

    },

    getRateInfo() {
      Axios.get('/exchange/' + this.country)
        .then(res => {
          if (res.data.success) {
            this.rate = res.data.rate
            this.rateText = this.toAmountString(res.data.rate)
          } else {
            this.message = res.data.message
          }
        })
    },

    toAmountString(val) {
      let str = val.toFixed(2).toString().split(".");
      str[0] = str[0].replace(/[^-\\.0-9]/g,'').replace(/(.)(?=(\d{3})+$)/g,'$1,');
      return str.join('.');
    },

    countryChange() {
      this.getRateInfo();
    },

    calculator() {
      if (this.remittanceAmount > 10000 || this.remittanceAmount < 0) {
        alert("송금액이 바르지 않습니다")
        return
      }

      let amount = this.remittanceAmount * this.rate;
      let countryText = ' ' + this.country.toUpperCase() + ' 입니다.'

      this.message = '수취금액은 ' + this.toAmountString(amount) + countryText
    }
  }

}
</script>

<style scoped>

</style>
