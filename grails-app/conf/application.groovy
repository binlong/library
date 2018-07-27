

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'library.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'library.UserRole'
grails.plugin.springsecurity.authority.className = 'library.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/book/**',        access: ['permitAll'], httpMethod: 'GET'],
	[pattern: '/book/**',        access: ['ROLE_WRITE'], httpMethod: 'POST'],
	[pattern: '/book/**',        access: ['ROLE_WRITE'], httpMethod: 'PUT'],
	[pattern: '/book/**',        access: ['ROLE_WRITE'], httpMethod: 'DELETE'],
	[pattern: '/book/search',    access: ['permitAll']],
	[pattern: '/application/**',    access: ['permitAll']]
]
grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

