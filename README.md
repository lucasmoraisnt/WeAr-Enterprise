# WeAr

### Cadastrar Usuario
`POST `/wear/api/usuario

| campo | tipo | obrigatório | descrição
| --- | :---: | :---: | ---
| usuarioId | Long | sim | número de identificação do usuário, gerado automaticamente
| nome | String | sim | nome completo do usuário
| email | String | sim | email de acesso do usuário
| senha | String | sim | senha de acesso do usuário 
| dataNascimento | date | nao | data de nascimento do usuário
| genero | String | nao | gênero do usuário
| endereco | String | nao | endereço de cadastro do usuário
| telefone | String | nao | telefone de cadastro do usuário
| dataCadastro | date | sim | data de cadastro do usuário

### Cadastrar Peças de Vestuário
`POST `/wear/api/pecasVestuario

| campo | tipo | obrigatório | descrição
| --- | :---: | :---: | ---
| pecasVestuarioId | Long | sim | número de identificação da peça de vestuário, gerado automaticamente
| nome | String | sim | nome da peça de vestuário
| categoria | String | sim | categoria da peça de vestuário
| marca | String | sim | marca da peça de vestuário
| tamanho | String | sim | tamanho da peça de vestuário
| cor | String | sim | cor da peça de vestuário
| material | String | sim | tipo de material da peça
| imagem | String | sim | imagem ilustrativa da peça de vestuário
| preço | decimal | sim | valor da peça
| dataCadastro | date | sim | data de cadastro da peça de vestuário


### Cadastrar Medidas
`POST `/wear/api/medidas

| campo | tipo | obrigatório | descrição
| --- | :---: | :---: | ---
| medidasId | Long | sim | número de identificação da medida do usuário, gerado automaticamente
| altura | double | sim | medida da altura do usuãrio
| peso | double | sim | valor do peso do usuário
| busto | double | sim | medida do busto do usuário
| cintura | double | sim | medida da cintura do usuário
| quadril | double | sim | medida do quadril do usuário
| ombro | double | sim | medida do ombro do usuário
| comprimentoBraco | double | sim | medida do comprimento do braço do usuário
| comprimentoPerna | double | sim | medida do comprimento da perna do usuário
| dataCadastro | date | sim | data de cadastro da medida do usuário

### Cadastrar Avaliações
`POST `/wear/api/avaliacoes

| campo | tipo | obrigatório | descrição
| --- | :---: | :---: | ---
| avaliacoesId | Long | sim | número de identificação da avaliação, gerado automaticamente
| nota | int | sim | nota de avaliação do usuário
| comentario | String | nao | comentário do usuário sobre a peça
| dataCadastro | date | sim | data de cadastro da avaliação do usuário
