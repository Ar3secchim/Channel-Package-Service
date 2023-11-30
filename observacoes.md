# Observações para o projeto de pacotes

## Observações sobre o projeto

    1. A classe HTTPCustom chama uma outra classe (RestTemplate). Em relação ao nome da classe, poderia ter sido utilizada um nome mais intuitivo que informasse a consulta ao serviço de promoções.
    Em relação ao uso do RestTemplate, este já esta em desuso. Procura utilizar o WebClient, ou uma das soluções disponíveis (feign, retrofit, http interfaces, etc.) Em nossa aula utilizamos Http Interfaces (presente desde a versão 6 do spring)
    como exemplo para este tipo de conexão REST.

    
