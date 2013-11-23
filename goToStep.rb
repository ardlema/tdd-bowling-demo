v1 = ARGV[0]

step1 = "847177deef52d29888d6e7c00b8d96444abcdb44"
step2 = "f1871578eca32fe28662f9e83379fc64292b7d27"
step3 = "82fe2c181266ae73271d44caf90550758fdb3066"
step4 = "c5f912a65283151c4c60b4f99ac208dde1986de3"
step5 = "505f860aebd2342553a42119196ea44b45dd1702"
step6 = "7ce8dbc9173a46baf378d3ba9b35352656cafcf3"
step7 = "133e249b091c088d0e452afd23eb0c78a07f24cf"
step8 = "276f49bdea5d0668d5a7605c81916e1d8b333d5c"
step9 = "939d1f36efce6a59bb55638dd3c490330a7302c3"
step10 = "cff69ffc18f45552d71cccee8353a9e9c437822f"
step11 = "8473e685432a0ff019c8877f640eb2d0fb5c3535"
step12 = "85ed034ea90c505830101137f65b8723e4b5f61a"
step13 = "f155c2f5c5118021fb21b5110f2b0b3e69c46a5c"
step14 = "375579683e8f96d3e29f9afdc7f4bc8220f65059"
step15 = "7df41ae46a7923d309112770ba3479dddbd75928"
step16 = "81cfc2779f11c0f76cb764cb563df71ae21051ff"
step17 = "3c55c5db2fff269cba09f56125bf2b8a5dfe5d0c"
step18 = "cf15d8bafa33661220ce9622a368ee34a1a7a260"
step19 = "7d603e1b6951abbf3a229539f90a8b12e2d8bddb"
step20 = "7b61b7ed52ae4510b2112d7d4715c48b49780693"
step21 = "47b88419a315b857653d469a389dbe131540649c"
step22 = "5bb5bb3f1cb4e4653d304b5f99917d02fc771d80"
step23 = "aca492dfe5bd9a59934247bdff352aa0f059a3f3"
step24 = "5f18e780a4e317e841d2a673f56f03e9014db366"
step25 = "d519a9d5bac7fb2e13a1ee5e54943de75fc15a67"
step26 = "5ec8cca67408dc7d9c9b16f766ae1cfaae475f33"
step27 = "b016eb9d03505e94cd6bd7d9d9c442ce225dbb13"
step28 = "8afd03ab17d3f291fed4b830f22b5b20a3a80e3e"
step29 = "256f2e5633493bb0b17bd63633f0c0bb662bfe64"
step30 = "1922bd4ebeedc85ea99a2918dbfda71febe8bd21"
step31 = "9da08e2c2261c4aa4a359e42422840c726bddf2e"
step32 = "a29a25a92673ee1c8128e030643fb61d80776002"
step33 = "e6c2f5f2bebfde6d09eb8547698d7891a5acde78"
step34 = "be91c0f26b130288b5d1044c206223b52ef50cea"
step35 = "b9b58385e88233b0e2c201e6f30412d37eccf89e"
step36 = "33bb199eabe2eaaf06b469a2eb0bfe9cd365bd90"
step37 = "1acec45b3ec67ead38803a93acc6394533cc7d68"
step38 = "f6abe6854de019a98c98e1192993865b5cbf7817"
step39 = "2f9ddcc8205c65dfe510bb425c84756d2ef812dc"
step40 = "6d2fdfd6f3b0f744da76436852f497109314deaf"
step41 = "9cc1621fe95cbd1707a9b1a06045c60b9ec3fb34"
step42 = "86d313692d1196694d2876a9f389449d7e61a1b2"

command = "git checkout "

case v1.to_i
when 1
  command << step1
when 2
  command << step2
when 3
  command << step3
when 4
  command << step4
when 5
  command << step5
when 6
  command << step6
when 7
  command << step7
when 8
  command << step8
when 9
  command << step9
when 10
  command << step10
when 11
  command << step11
when 12
  command << step12
when 13
  command << step13
when 14
  command << step14
when 15
  command << step15
when 16
  command << step16
when 17
  command << step17
when 18
  command << step18
when 19
  command << step19
when 20
  command << step20
when 21
  command << step21  
when 22
  command << step22
when 23
  command << step23
when 24
  command << step24
when 25
  command << step25
when 26
  command << step26
when 27
  command << step27
when 28
  command << step28
when 29
  command << step29  
when 30
  command << step30  
when 31
  command << step31   
when 32
  command << step32
when 33
  command << step33  
when 34
  command << step34   
when 35
  command << step35
when 36
  command << step36
when 37
  command << step37
when 38
  command << step38
when 39
  command << step39
when 40
  command << step40
when 41
  command << step41
when 42
  command << step42
else
  puts "You gave me #{v1} -- I have no idea what to do with that."
  command = ""
end

system(command)
