# Utilizando a aplicação

- Verificar se conexão com banco de dados está funcionando corretamente
- Caso seja alterado a porta do servidor mudar a URL da requisição para nova porta
- Substituir {id} pelo ID desejado
- As opções de EstadoCivil são: SOLTEIRO, CASADO, DIVORCIADO, VIUVO

1. Obter todos os endereços:

- Método: **GET**
- URL: localhost:8080/address
- Corpo da requisição: vazio
- Resposta esperada: 200 OK com um array de endereços no corpo da resposta

2. Obter endereço por ID:

- Método: **GET**
- URL: localhost:8080/address/{id}
- Corpo da requisição: vazio
- Resposta esperada: 200 OK com um endereço correspondente ao ID especificado ou 404 NOT FOUND se o ID não for encontrado

3. Inserir um novo endereço:

- Método: **POST**
- URL: localhost:8080/address/save
- Corpo da requisição: objeto JSON representando o endereço a ser inserido; EX:

```
  {
  "nome": "Nome da Pessoa",
  "cpf": "000.000.000-00",
  "rg": "0000000000",
  "dataDeNascimento": "2020-01-10",
  "estadoCivil": "SOLTEIRO",
  "telefone": "Telefone",
  "email": "email@email.com"
  }
```

- Resposta esperada: 200 OK com o objeto JSON do endereço inserido ou 400 BAD REQUEST se ocorrer algum erro na inserção

4. Atualizar um endereço existente:

- Método: **PUT**
- URL: localhost:8080/address/update
- Corpo da requisição: objeto JSON representando o endereço a ser atualizado

```
  {
  "nome": "Nome da Pessoa",
  "cpf": "000.000.000-00",
  "rg": "0000000000",
  "dataDeNascimento": "2020-01-10",
  "estadoCivil": "SOLTEIRO",
  "telefone": "Telefone",
  "email": "email@email.com"
  }
```

**OBS**: Você pode omitir os dados que não serão atualizados, e a aplicação irá utilizar os dados do banco de dados; EX:

```
{
    "estadoCivil": "CASADO"
}
```

- Resposta esperada: 200 OK com o objeto JSON do endereço atualizado ou 400 BAD REQUEST se ocorrer algum erro na atualização

5. Excluir um endereço:

- Método: **DELETE**
- URL: localhost:8080/address/delete?id={id}
- Resposta esperada: 200 OK ou 400 BAD REQUEST se ocorrer algum erro na exclusão.
