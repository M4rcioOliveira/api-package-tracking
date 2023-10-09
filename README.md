# API Tracker Package


Inspirado no serviço de rastreio do **Mercado Livre**, que notifica quando uma encomenda está próxima de ser entregue, desenvolvi um serviço semelhante. Esse serviço identifica quando uma encomenda está prestes a ser entregue com base na latitude e longitude do local da última situação de entrega registrada.

É importante destacar que este serviço considera uma rota planejada de entregas em fila. Suponha que as próximas entregas sejam X e Y. Ou seja, após a encomenda Y ter sua situação registrada, quando o entregador atualiza o status da encomenda Y, a latitude e longitude do local atual são enviadas para o serviço. O serviço, então, se comunica com o Google para calcular a previsão de horário de entrega com base na distância restante até o destino.

Dessa forma, os destinatários podem receber notificações com o horário estimado de entrega, o que torna o processo de entrega mais transparente e conveniente.


# Features

- [x] Cadastro de Cliente
- [x] Cadastro de Encomenda
- [x] Rastreio de Encomenda via CPF/CNPJ
- [ ] Atualização da Situação
- [ ] Rota Planejada
- [ ] WebHook

Em desenvolvimento...