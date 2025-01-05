# Insurance Quotation Case

## Introdução
Case usando Spring Boot para simular ambiente de Cotação de Seguros.

## Tecnologias
As seguintes tecnologias foram utilizadas no projeto

- Spring Boot (Web, JPA)
- MongoDB
- Server Mock

## Arquitetura
Para fins acadêmicos e de aprendizado, esta solução utiliza Arquitetura Hexagonal. Importante destacar que essa arquitetura contempla isolar o Core, dos componentes de borda (adapters). Em contra partida, a complexidade de camadas e componentes aumenta proporcionalmente.

- Spring Boot
- MongoDB

É claro que pensando em DDD, podemos isolar os micro-serviços que se integram com componentes externos. Daí então, seria viável criar micro-serviço para integrar com os componentes Insurance Policy e Insurance Product e o micro-serviço Core atuaria como orquestrador (Microservices Orchestration Pattern).  

<img src="./doc/Insurance Quotation.drawio.png" alt="Component Diagram - C4 Model"/>  

## Docker Compose
Estando no diretório do projeto executar (Linux):  
### Start
 
```linux Linux command
$ sudo docker compose up --force-recreate --build
```

### Stop
$ [CTRL + C]  

## Testes
OBS: Foi implementado conceito mínimo para execução dos testes. Claro que é necessário avaliar o nível de abrangência dos testes.  

### Teste Unitário
Classe: com.lfchaim.insurance.quotation.unit.InvoiceQuotationTest  

### Testes E2E
Validação da API completa com RestAssured  
Classe: com.lfchaim.insurance.quotation.test.e2e.InvoiceQuotationTestE2E  

