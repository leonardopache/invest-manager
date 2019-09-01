## AFA Management
App para fazer o acompanhamento da carteira de ações e FIIs pessoal, criar pesquisas baseada em análise fundamentalista para identificação de ativos para acompanhamento, acompanhamento com notificações dos ativos que segue e informações sobre valores, fatos relevantes e distribuições/subscrições dos ativos na carteira.

Manutenção de Perfil (account-manager)
-------------
Como ponto inicial do sistema o usuário deve realizar o cadastro em AFA Market informando dados básicos, nome completo, e-mail, senha.
- Serviço POST para criar perfil:
`curl -x POST [server]/afa/account-manager`
- Parâmetros:
`none`
- JSON body:
```json
{
	'name' : '',
	'lastName' : '',
	'mail' : '',
	'pwd' : '' (encryped)
}
```
- JSON Response:
```json
{
	'status' :'HTTP.status',
	'response.msg' :''
}
```
- Serviço GET para buscar dados do perfil:
`curl GET [server]/afa/account-manager/{account-id}`
- Parâmetros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'id':''
	'name':'',
	'lastName':'',
	'mail':''
}
```
- Serviço PUT para atualizar dados do perfil:
`curl -x PUT [server]/afa/account-manager/{account-id}`
- Parâmetros:
`none`
- JSON body:
```json
{
	'name':'',
	'lastName':'',
	'mail':'',
	'pwd':'' (encryped)
}
```
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```
- Serviço DELETE para remover perfil:
`curl -x DELETE [server]/afa/account-manager/{account-id}`
- Parametros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```

Manutenção de Carteira (wallet)
-------------
CRUD simples para agrupamento dos ativos de acordo com o perfil, pode ter múltiplas carteiras, uma carteira é obrigatória, ativos de uma carteira sao monitorados por jobs de análise padrão e/ou customizado.
- Serviço POST para criar Carteira:
`curl -x POST [server]/afa/account-manager/{account-id}/wallet`
- Parâmetros:
`none`
- JSON body:
```json
{
	'description':'',
	'name':''
}
```
- JSON Response
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```
- Serviço GET para buscar dados da carteira:
`curl GET [server]/afa/account-manager/{account-id}/wallet/{wallet-id}`
- Parâmetros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'id':'',
	'name':'',
	'description':'',
	'dataWallet':[
	{
		'mkt-cod':'',
		'isbn':'',
		...
	},
	{
		'mkt-cod':'',
		'isbn':'',
		...
	}]
}
```
Serviço PUT para atualizar dados do carteira:
`curl -x PUT [server]/afa/account-manager/{account-id}/wallet/{wallet-id}`
- Parâmetros:
`none`
- JSON body:
```json
{
	'name':'',
	'description':''
}
```
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```
- Serviço DELETE para remover carteira:
`curl -x DELETE [server]/afa/account-manager/{account-id}/wallet/{wallet-id}`
- Parametros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```

Manutenção dos ativos na carteira:
-------------
Manualmente e Automaticamente deve ser possível a inclusão, edição ou exclusão dos ativos de uma carteira, cada ativo deve ser cadastrado com informações tipo (TPATIVO, TPACTION, BROKER, ISIN, TICKER, SHARES, VALUE_BUY, DATE_BUY, BROKER_EXPENSES, WALLETID), para edição o objetivo é incluir novas compras ao mesmo ativo (neste caso deve ser guardado um histórico para avaliação individual no tempo) fazer correções pontuais. A exclusão ira remover o ativo e seu histórico, caso seja uma venda o melhor é cadastrar como uma edição do tipo resgate.
A manutenção da carteira terá grande atuação de jobs para atualização de valores (consolidação diária após o fechamento), cálculo de indicadores Fundamentalistas dos Ativos e zonas para alertas quando o indicador tiver um desempenho fora dessas zonas, % de rendimentos, avisos gerais (Dividendos, Juros Capital, Fato relevante, Subscrição, etc).
- Serviços CRUD:
- Serviço POST para criar Carteira:
`curl -x POST [server]/afa/account-manager/{account-id}/wallet/{wallet-id}/stock/`
- Parâmetros:
`none`
- JSON body:
```json
{
	'TPATIVO':'',
	'TPACTION':'',
	'BROKER':'',
	'TICKER':'',
	'ISIN':'',
	'SHARES':'',
	'VALUE_BUY':'',
	'DATE_BUY':'',
	'BROKER_EXPENSES':'',
	'WALLETID':''
}
```
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```
- Serviço GET para buscar dados do Ativo:
`curl GET [server]/afa/account-manager/{account-id}/wallet/{wallet-id}/stock/{stock-id}`
- Parâmetros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'TPATIVO':'',
	'TPACTION':'',
	'BROKER':'',
	'TICKER':'',
	'ISIN':'',
	'SHARES':'',
	'VALUE_BUY':'',
	'DATE_BUY':'',
	'BROKER_EXPENSES':'',
	'WALLETID':''
}
```
- Serviço PUT para atualizar dados do ativo:
`curl -x PUT [server]/afa/account-manager/{account-id}/wallet/{wallet-id}/stock/{stock-id}`
- Parâmetros:
`none`
- JSON body:
```json
{
	'TPATIVO':'',
	'BROKER':'',
	'SHARES':'',
	'VALUE_BUY':'',
	'DATE_BUY':'',
	'BROKER_EXPENSES':'',
	'WALLETID':''
}
```
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```
- Serviço DELETE para remover Ativo:
`curl -x DELETE [server]/afa/account-manager/{account-id}/wallet/{wallet-id}/stock/{stock-id}`
- Parâmetros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'status':'HTTP.status',
	'response.msg':''
}
```
- Serviços Business:
- Serviço para buscar histórico de ações na carteira ordenado por data da ação
- Serviço para buscar histórico do ativo
`curl GET [server]/afa/account-manager/{account-id}/history`
- Parâmetros:
`wallet-id (optional), stock-id (optinoal)`
- JSON body:
`none`
- JSON Response:
```json
{
	'action':'',
	'date':'',
	'walletId':'',
	'ticker':'',
	'info':''
}
```
- Serviço para buscar histórico de recebimentos (dividendo, juros, etc.)
`curl GET [server]/afa/account-manager/{account-id}/history`
- Parâmetros:
`wallet-id (optional), stock-id (optinoal), action`
- JSON body:
`none`
- JSON Response:
```json
{
	'action':'',
	'date':'',
	'walletId':'',
	'ticker':'',
	'info':''
}
```
- Serviço para buscar indicadores fundamentalista da carteira
	(Para desempenho criar histórico mensal dos indicadores pre calculados com job mensal. Como opção se pode replicar os dados em uma estrutura dependente do relacionamento ativo e usuário)
`curl GET [server]/afa/account-manager/{account-id}/fundamentus`
- Parâmetros:
`none`
- JSON body:
```json
[
	{
		'ticker':''
	},
	{
		'ticker':''
	},
	...
]
```
- JSON Response:
```json
{
	'ticker':'',
	'index':[
	{
		'name':''
	},
	{	
		'name':''
	}]
}
```
- Serviço para buscar rentabilidade da carteira detalhada por ativo
	(Rentabilidade é uma estrutura da relação entre usuário e ativo, os valores podem ser atualizados sempre que o valor de mercado, data ou quantidade sejam alterados. A rentabilidade diária deve ser historizada para implementação de gráficos e avaliação de desempenho no passar do tempo.)
`curl GET [server]/afa/account-manager/{account-id}/wallet/{wallet-id}/performance`
- Parâmetros:
`none`
- JSON body:
`none`
- JSON Response:
```json
{
	'date':'',
	'walletId':'',
	'TPATIVO':'',
	'ticker':'',
	'priceOpen':'',
	'priceClose':'',
	'performance':'',
	'mktIndex':[
	{
		'name':'',
		'value':''
	}],
	'':'',
	'info':''
}
```

Acompanhamento de mercado (market-follow)
-------------
Área customizada para acompanhamento do mercado dos ativos em carteira, criação de watch list, definição de parâmetros fundamentalista, consultas de acordo com parâmetros pré-definidos. Uma base, CORE, de funcionalidades devem ser definidas e disponibilizada a todos perfis e também poderá criar ações customizadas disponíveis apenas ao perfil. 
