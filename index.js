const { sm4, sm3, sm2 } = require('../src/index')
const {encodeDer, decodeDer} = require('../src/sm2/asn1')

// const sm4 = require('../src/sm4/index')
const msg = 'hello' // 可以为 utf8 串或字节数组

console.log ('========begin SM2===================')

const publicKey = '04ec7e40b8dfa4b14383f703ec5403b71db0ab505b9fc41f0df45a9910a307dfbd5b3c5afdd4b90d79fa0ab70d53fd88422df77e09b254a53e72b4857f74ab1da4' // 公钥
const privateKey = '58967e2beb6fffd3c96545eebd3000b39c10087d48faa0d41f9c7bf3720e0ea4' // 私钥

console.log(sm2.doSignature(msg, privateKey, { hash:true, der:true }))

//这里的vsign是java生成的
const vSign = '30450220149d990885febfe0c399ac4481842a4452fb1e6a19de477ee5e5b7faac75686d022100be707161f13aacf6f5fd3a224a96faeee2309439767d4d0878bffafc8d86c6f6'
const ver2 = sm2.doVerifySignature(msg, vSign, publicKey, { hash:true, der:true })

// console.log(sigValueHex)
console.log('verifyResult', ver2)
