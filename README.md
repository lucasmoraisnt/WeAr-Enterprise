# WeAr

### Cadastrar pessoa
`POST `/wear/api/pessoa

| campo | tipo | obrigatório | descriçãos
| --- | :---: | :---: | ---
| id_pessoa | long | sim | é o id da pessoa
| nome | text | sim | é nome da pessoa
| rg | long | sim | é o rg da pessoa
| data de nascimento | String | sim | é a data de nascimento da pessoa
| sexo | char | sim | recebará o value do sexo da pessoa

### Cadastro do produto
`POST `/wear/api/produto

| campo | tipo | obrigatório | descriçãos
| --- | :---: | :---: | ---
| id_produto | long | sim | é o id da produto
| nome | string | sim | é o nome do produto
| preço | double | sim | recebera o preço do produto
| cor | char | sim | recebará o value da cor do produto
| tamanho | char | sim | recebará o value do tamanho do produto

### Cadastro das medidas
`POST `/wear/api/medidas

| campo | tipo | obrigatório | descriçãos
| --- | :---: | :---: | ---
| id_medida | long | sim | é o id da medida da pessoa
| altura | int | sim | é a altura da pessoa
| busto | double | sim | é o busto da pessoa
| cintura | double | sim | é a cintura da pessoa
| quadril | double | sim | é o quadril da pessoa
