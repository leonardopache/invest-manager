### AFA Manager
App para fazer o acompanhamento da carteira de açoes e FIIs pessoal, criar pesquisas baseada em análise fundamentalista para identificaçao de ativos para acompanhamento, acompanhamento com notificaçoes dos ativos que segue e informaçoes sobre valores, fatos relevantes e distribuiçoes/subscriçoes dos ativos na carteira.

Manutençao de Perfil (account-manage)
-------------
Como ponto inicial do sistem o usuário deve realizar o cadastro em AFA Market informando dados basicos, nome completo, email, senha.
- Serviço POST para criar perfil:
`curl -x POST [server]/afa/account-manage`
- Parametros:
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
`curl GET [server]/afa/account-manage/{account-id}`
- Parametros:
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
`curl -x PUT [server]/afa/account-manage/{account-id}`
- Parametros:
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
`curl -x DELETE [server]/afa/account-manage/{account-id}`
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

Manutençao de Carteira (wallet)
-------------
CRUD simples para agrupamento dos ativos de acordo com o perfil, pode ter multiplas carteiras, uma carteira é obrigatória, ativos de uma carteira sao monitorados por jobs de análise padrao e/ou customizado.
- Serviço POST para criar Carteira:
`curl -x POST [server]/afa/account-manage/{account-id}/wallet`
- Parametros:
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
`curl GET [server]/afa/account-manage/{account-id}/wallet/{wallet-id}`
- Parametros:
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
`curl -x PUT [server]/afa/account-manage/{account-id}/wallet/{wallet-id}`
- Parametros:
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
`curl -x DELETE [server]/afa/account-manage/{account-id}/wallet/{wallet-id}`
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

Manutençao dos ativos na carteira:
-------------
Manualmente e Automaticamente deve ser possivel a inclusao, edicao ou exclusao dos ativos de uma carteira, cada ativo deve ser cadastrado com informacoes tipo (TPATIVO, TPACTION, BROKER, ISIN, TICKER, SHARES, VALUE_BUY, DATE_BUY, BROKER_EXPENSES, WALLETID), para edicao o objetivo é incluir novas compras ao mesmo ativo (neste caso deve ser guardado um historico para avaliaçao individual no tempo) fazer correçoes pontuais. A exclusao ira remover o ativo e seu historico, caso seja uma venda o melhor eh cadastrar como uma edicao do tipo resgate.
A manutencao da carteira tera grande atuaçao de jobs para atualizaçao de valores (consolidaçao diaria apos o fechamento), Calculo de indicadores Fundamentalistas dos Ativos e zonas para alertas quando o indicador tiver um desempenho fora dessas zonas, % de rendimentos, avisos gerais (Dividendos, Juros Capital, Fato relevante, Subscriçao, etc).
- Serviços CRUD:
- Serviço POST para criar Carteira:
`curl -x POST [server]/afa/account-manage/{account-id}/wallet/{wallet-id}/stock/`
- Parametros:
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
`curl GET [server]/afa/account-manage/{account-id}/wallet/{wallet-id}/stock/{stock-id}`
- Parametros:
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
`curl -x PUT [server]/afa/account-manage/{account-id}/wallet/{wallet-id}/stock/{stock-id}`
- Parametros:
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
`curl -x DELETE [server]/afa/account-manage/{account-id}/wallet/{wallet-id}/stock/{stock-id}`
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
- Serviços Business:
- Serviço para buscar historico de açoes na carteira ordenado por data da açao
- Serviço para buscar historico do ativo
`curl GET [server]/afa/account-manage/{account-id}/history`
- Parametros:
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
- Serviço para buscar historico de recebimentos (dividendo, juros, etc)
`curl GET [server]/afa/account-manage/{account-id}/history`
- Parametros:
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
	(para desempenho criar historico mensal dos indicadores pre calculados com job mensal. Como opçao se pode replicar os dados em uma estrutura dependente do relacionamento ativo e usuario)
`curl GET [server]/afa/account-manage/{account-id}/fundamentus`
- Parametros:
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
	(Rentabilidade é uma estrutura da relaçao entre usuario e ativo, os valores podem ser atualizados sempre que o valor de mercado, data ou quantidade sejam alterados. A rentabilidade diária deve ser historizada para implementaçao de graficos e avaliaçao de desempenho no passar do tempo.)
`curl GET [server]/afa/account-manage/{account-id}/wallet/{wallet-id}/performance`
- Parametros:
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
Area customizavel para acompanhamento do mercado dos ativos em carteira, criaçao de watch list, definiçao de paramentros fundamentalista, consultas de acordo com paramentros pré definidos. Uma base, CORE, de funcionalidades devem ser definidas e disponibilizada a todos perfis e tambem poderá criar açoes customizadas disponiveis apenas ao perfil. 
	
	
	
	
	
	
	
