# GPLAYJAVAEE

Archetype para criar projetos REST EE com a LIB rest-util.

## Informações
* **Tipo:** DEMO
* **Finalidade:** Demostrar a utilização do ARCHETYPE restee
* **Gerenciamento e Automação:** Maven

## Como Gerar o Archetype

Para compilar e gerar o pacote rode:

	mvn clean package

Para fazer o deploy:

	mvn tomee:run

As seguintes URL's estão disponíveis:
* http://localhost:8080/gplayjavaee/api/cargos
* http://localhost:8080/gplayjavaee/api/analistas
* http://localhost:8080/gplayjavaee/api/projetos

Veja com arquivo POM, pois possui várias informações e opções de uso, como rodar no Jboss 7.
		
		
		