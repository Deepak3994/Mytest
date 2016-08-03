class Tab extends Component {
	private String url;

    public String getUrl() {
        return this.url;
    }

    @Override
    public void reset() {
    	url = null;
    }
}
