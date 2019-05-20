///**
// * 
// */
//package es.pache.spring.account.manager.config.facebook;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.social.UserIdSource;
//import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
//import org.springframework.social.config.annotation.EnableSocial;
//import org.springframework.social.config.annotation.SocialConfigurer;
//import org.springframework.social.connect.ConnectionFactoryLocator;
//import org.springframework.social.connect.UsersConnectionRepository;
//
///**
// * @author lmarquespache
// *
// */
//@Configuration
//@EnableSocial
//public class SocialConfiguration implements SocialConfigurer {
//
//	/* (non-Javadoc)
//	 * @see org.springframework.social.config.annotation.SocialConfigurer#addConnectionFactories(org.springframework.social.config.annotation.ConnectionFactoryConfigurer, org.springframework.core.env.Environment)
//	 */
//	@Override
//	public void addConnectionFactories(ConnectionFactoryConfigurer connFactoryConfig, Environment env) {
//		connFactoryConfig.addConnectionFactory(new FacebookCustomApiVersionConnectionFactory("2.7", "appId","appSecret"));
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.social.config.annotation.SocialConfigurer#getUserIdSource()
//	 */
//	@Override
//	public UserIdSource getUserIdSource() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.social.config.annotation.SocialConfigurer#getUsersConnectionRepository(org.springframework.social.connect.ConnectionFactoryLocator)
//	 */
//	@Override
//	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
