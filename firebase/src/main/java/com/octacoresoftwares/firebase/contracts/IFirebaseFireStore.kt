package com.octacoresoftwares.firebase.contracts

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference

interface IFirebaseFireStore {
    fun <D> addDataToCollection(collectionPath: String, data: D): Task<DocumentReference>?

    fun <D> setDataToDocumentInCollection(collectionPath: String, documentId: String, data: D): Task<Void>?

    fun <D> setDataToDocumentWithMerge(collectionPath: String, documentId: String, data: D): Task<Void>?

    fun <F> updatingFieldInDocument(collectionPath: String, documentId: String, fieldRef: String, data: F): Task<Void>?

    fun deleteDocumentFromCollection(collectionPath: String, documentId: String): Task<Void>?

    fun deleteFieldFromDocumentInCollection(collectionPath: String, documentId: String, fieldRef: String): Task<Void>?

    /*fun getSingleDocumentFromCollection(collectionPath: String, documentId: String): L?

    fun getAllDocumentsInCollection(collectionPath: String): L?

    fun <F> getAllDocumentsWithConditionInCollection(collectionPath: String, conditionKey: String, conditionValue: F): L?*/
}