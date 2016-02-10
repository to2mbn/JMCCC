package org.to2mbn.jmccc.mcdownloader.download;

import org.to2mbn.jmccc.mcdownloader.download.concurrent.AsyncCallback;

public interface DownloadCallback<T> extends AsyncCallback<T> {

	/**
	 * Calls when the progress of the download operation has been updated.
	 * 
	 * @param done the downloaded bytes
	 * @param total the total bytes, -1 if unknown
	 */
	void updateProgress(long done, long total);

	/**
	 * Calls when the download failed and the downloader is going to retry the download task.
	 * <p>
	 * Notes: {@link #failed(Throwable)} will be called only when the download is failed and the downloader won't retry
	 * it any more. If the downloader is going to retry the download task, this method will be called, instead of
	 * {@link #failed(Throwable)}.
	 * 
	 * @param e the cause of download failure
	 * @param current the retry count (1 for the first, max-1 for the latest)
	 * @param max the max number of tries
	 */
	void retry(Throwable e, int current, int max);

}