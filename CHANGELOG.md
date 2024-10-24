 # Changelog

As principais alterações neste projeto serão documentadas neste arquivo.

Este formato é baseado em [Mantendo um Changelog](http://keepachangelog.com/en/1.0.0/)
e este projeto é aderente ao [Versionamento Semântico](http://semver.org/spec/v2.0.0.html).

<!--
Adicionado       para novas funcionalidades.
Modificado       para mudanças em funcionalidades existentes.
Obsoleto         para funcionalidades estáveis que foram removidas das próximas versões.
Removido         para funcionalidades removidas desta versão.
Corrigido       para qualquer correção de bug.
Segurança        para incentivar usuários a atualizarem em caso de vulnerabilidades.
-->

## [1.1.0] - 23/10/2024
## Adicionado
 - Dockerfile para containerização da aplicação.
 - Docker Compose para gerenciar o serviço em container.
 - GitIgnore

## Modificado
 - Atualização Java 17 e Spring Boot 3.2.5.
 - Atualização do pom.xml para garantir dependências atualizadas e resolver problemas com o PIT (Mutation Testing).
 - Refatoração nas classes para utilizar WebClient.
 - Testes unitários para adaptar à nova implementação do WebClient.
