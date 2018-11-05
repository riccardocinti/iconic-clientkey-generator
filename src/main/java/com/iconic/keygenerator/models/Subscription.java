package com.iconic.keygenerator.models;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
    +----------------------+--------------+------+-----+---------+----------------+
	| Field                | Type         | Null | Key | Default | Extra          |
	+----------------------+--------------+------+-----+---------+----------------+
	| ID                   | int(11)      | NO   | PRI | NULL    | auto_increment |
	| CLIENT_KEY           | varchar(255) | NO   | MUL | NULL    |                |
	| ISSUBSCRIPTIONACTIVE | tinyint(1)   | YES  |     | NULL    |                |
	| EXPIRE_DATE          | date         | NO   |     | NULL    |                |
	| WORDCOUNTQUOTA       | bigint(20)   | NO   |     | 0       |                |
	| PAGECOUNTQQOTA       | bigint(20)   | NO   |     | 0       |                |
	| FILESIZEBYTEQUOTA    | bigint(20)   | NO   |     | 0       |                |
	+----------------------+--------------+------+-----+---------+----------------+
 *
 */
@Data
@Entity
@Table(name = "SUBSCRIPTION")
@NoArgsConstructor
public class Subscription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(targetEntity = ClientKey.class)
	@JoinColumn(name = "CLIENT_KEY")
	private ClientKey clientKey;
	
	@Column(name = "ISSUBSCRIPTIONACTIVE")
	private Boolean activeSubscription;
	
	@Column(name = "EXPIRE_DATE")
	private Date expiryDate;
	
	@Column(name = "WORDCOUNTQUOTA")
	private BigInteger words;
	
	@Column(name = "PAGECOUNTQQOTA")
	private BigInteger pages;
	
	@Column(name = "FILESIZEBYTEQUOTA")
	private BigInteger fileSize;
}
